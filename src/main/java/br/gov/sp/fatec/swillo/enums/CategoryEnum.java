package br.gov.sp.fatec.swillo.enums;

public enum CategoryEnum {
    IPA(""), APA(""), PILSEN(""), LARGER(""), COQUETEL("");

    public String description;
    CategoryEnum(String category){
        description = category;
    }

    public String getCategory() {
        return description;
    }
}
