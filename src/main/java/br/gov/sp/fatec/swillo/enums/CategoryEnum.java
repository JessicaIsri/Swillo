package br.gov.sp.fatec.swillo.enums;

public enum CategoryEnum {
    IPA(""), WEISS(""), STOUT(""), LARGER(""), SGA(""), TACA(""), CANECA("");

    public String description;
    CategoryEnum(String category){
        description = category;
    }

    public String getCategory() {
        return description;
    }
}
