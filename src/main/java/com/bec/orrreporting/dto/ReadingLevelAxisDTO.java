/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright BEC - All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * MAY 23 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.orrreporting.dto;

public class ReadingLevelAxisDTO {

    private String levelName;
    private String levelBgColor;
    private String levelAxisColor;
    private String levelHoverColor;

    public ReadingLevelAxisDTO(String levelName, String levelBgColor, String levelAxisColor, String levelHoverColor) {
        this.levelName = levelName;
        this.levelBgColor = levelBgColor;
        this.levelAxisColor = levelAxisColor;
        this.levelHoverColor = levelHoverColor;
    }

    public ReadingLevelAxisDTO() {
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelBgColor() {
        return levelBgColor;
    }

    public void setLevelBgColor(String levelBgColor) {
        this.levelBgColor = levelBgColor;
    }

    public String getLevelAxisColor() {
        return levelAxisColor;
    }

    public void setLevelAxisColor(String levelAxisColor) {
        this.levelAxisColor = levelAxisColor;
    }

    public String getLevelHoverColor() {
        return levelHoverColor;
    }

    public void setLevelHoverColor(String levelHoverColor) {
        this.levelHoverColor = levelHoverColor;
    }
}
