package com.flaregames.stackoverflow.utility;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateConverterTest {

    @Test
    public void convertToDate() {
        Assert.assertEquals("2019-07-17T12:10:51",DateConverter.convertToDate("1563358251"));

    }
}