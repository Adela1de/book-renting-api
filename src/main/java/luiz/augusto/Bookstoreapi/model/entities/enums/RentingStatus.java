package luiz.augusto.Bookstoreapi.model.entities.enums;

import lombok.Getter;

public enum RentingStatus {

    WAITING_PAYMENT(1),
    RENTED(2),
    RETURN_DATE_EXPIRED(3),
    OUT_OF_STOCK(4);

    @Getter
    private int code;

    RentingStatus(int code) { this.code = code; }

    public static RentingStatus valueOf(int code)
    {
        for (RentingStatus x: RentingStatus.values()) {
            if(x.getCode() == code) return x;
        } throw new IllegalArgumentException("Invalid RentingStatus code! ");
    }
}
