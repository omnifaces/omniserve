/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.converter.ServeConverter;

/**
 * A date time converter.
 */
@ServeConverter(value = "org.omnifaces.serve.ext.converter.DateTimeConverter", forClass = Object.class)
public class DateTimeConverter implements Converter {

    /**
     * Stores the date style.
     */
    private String dateStyle;

    /**
     * Stores the locale.
     */
    private Locale locale;

    /**
     * Stores the pattern.
     */
    private String pattern;

    /**
     * Stores the time style.
     */
    private String timeStyle;

    /**
     * Stores the time zone.
     */
    private TimeZone timeZone;

    /**
     * Stores the type.
     */
    private String type;

    /**
     * Get as an object.
     *
     * @param string the string.
     * @return the object.
     */
    @Override
    public Object getAsObject(String string) {
        Date result = null;

        if (string != null && !"".equals(string.trim())) {
            DateFormat formatter = getDateFormat();
            if (timeZone != null) {
                formatter.setTimeZone(timeZone);
            }
            try {
                result = formatter.parse(string);
            } catch (ParseException ex) {
                throw new IllegalArgumentException("Unable to parse: " + string);
            }
        }

        return result;
    }

    /**
     * Get as a string.
     *
     * @param value the value.
     * @return the string.
     */
    @Override
    public String getAsString(Object value) {
        String result = "";

        if (value != null) {
            DateFormat formatter = getDateFormat();
            if (timeZone != null) {
                formatter.setTimeZone(timeZone);
            }
            result = formatter.format(value);
        }

        return result;
    }

    /**
     * Get the date format.
     *
     * @return the date format.
     */
    private DateFormat getDateFormat() {
        DateFormat result;

        if (pattern == null && type == null) {
            throw new IllegalArgumentException("Either pattern or type must be specified.");
        }

        if (locale == null) {
            throw new IllegalArgumentException("Locale cannot be null.");
        }

        if (pattern != null) {
            result = new SimpleDateFormat(pattern, locale);
        } else if (type.equals("both")) {
            result = DateFormat.getDateTimeInstance(getDateStyle(dateStyle), getDateStyle(timeStyle), locale);
        } else if (type.equals("date")) {
            result = DateFormat.getDateInstance(getDateStyle(dateStyle), locale);
        } else if (type.equals("time")) {
            result = DateFormat.getTimeInstance(getDateStyle(timeStyle), locale);
        } else {
            throw new IllegalArgumentException("Invalid type: " + type);
        }
        result.setLenient(false);
        return result;
    }

    /**
     * Get the date style.
     *
     * @param style the style.
     * @return the style constant.
     */
    private int getDateStyle(String style) {
        int result;

        if (style != null) {
            switch (style) {
                case "default":
                    result = DateFormat.DEFAULT;
                    break;
                case "short":
                    result = DateFormat.SHORT;
                    break;
                case "medium":
                    result = DateFormat.MEDIUM;
                    break;
                case "long":
                    result = DateFormat.LONG;
                    break;
                case "full":
                    result = DateFormat.FULL;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid style: " + style);
            }
        } else {
            throw new IllegalArgumentException("Style cannot be null.");
        }

        return result;
    }

    /**
     * Set the date style.
     *
     * @param dateStyle the date style.
     */
    public void setDateStyle(String dateStyle) {
        this.dateStyle = dateStyle;
    }

    /**
     * Set the locale.
     *
     * @param locale the locale.
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Set the pattern.
     *
     * @param pattern the pattern.
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Set the time style.
     *
     * @param timeStyle the time style.
     */
    public void setTimeStyle(String timeStyle) {
        this.timeStyle = timeStyle;
    }

    /**
     * Set the time zone.
     *
     * @param timeZone the time zone
     */
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * Set the type.
     *
     * @param type the type.
     */
    public void setType(String type) {
        this.type = type;
    }
}
