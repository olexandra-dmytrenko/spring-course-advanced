package beans.models;

/**
 * Created by olexandra on 05.02.17.
 * Add new entity to the application - UserAccount, it should store the amount of prepaid money user has in the system,
 * which should be used during booking procedure. Add methods for refilling the account to the BookingFacade class.
 * Add DAO and service objects for new entity. Add ticketPrice field to Event entity.
 */
public class UserAccount {
    private long userId;
    private double moneyAmount;
    private User user;

    public UserAccount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
