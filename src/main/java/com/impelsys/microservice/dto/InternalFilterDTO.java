package com.impelsys.microservice.dto;

public class InternalFilterDTO {

    private ProficiencyDTO proficiency;
    private LanguageDTO language;
    private CategoryDTO category;
    private TypeDTO type;

    public ProficiencyDTO getProficiency() {
        return proficiency;
    }

    public void setProficiency(ProficiencyDTO proficiency) {
        this.proficiency = proficiency;
    }

    public LanguageDTO getLanguage() {
        return language;
    }

    public void setLanguage(LanguageDTO language) {
        this.language = language;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }
}
