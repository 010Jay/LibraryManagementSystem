package Entity;

import java.util.Date;

public class Issue {

    private int issueID;
    private int userID;
    private int bookID;
    private Date issueDate;
    private int period;
    private Date returnDate;
    private double fine;

    public Issue(Builder builder) {
        this.userID = builder.userID;
        this.bookID = builder.bookID;
        this.issueDate = builder.issueDate;
        this.period = builder.period;
        this.returnDate = builder.returnDate;
        this.fine = builder.fine;
    }

    public int getIssueID() {
        return issueID;
    }

    public int getUserID() {
        return userID;
    }

    public int getBookID() {
        return bookID;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public int getPeriod() {
        return period;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueID=" + issueID +
                ", userID=" + userID +
                ", bookID=" + bookID +
                ", issueDate=" + issueDate +
                ", period=" + period +
                ", returnDate=" + returnDate +
                ", fine=" + fine +
                '}';
    }

        public static class Builder {

            private int userID;
            private int bookID;
            private Date issueDate;
            private int period;
            private Date returnDate;
            private double fine;

            public Builder setUserID(int userID) {
                this.userID = userID;
                return this;
            }

            public Builder setBookID(int bookID) {
                this.bookID = bookID;
                return this;
            }

            public Builder setIssueDate(Date issueDate) {
                this.issueDate = issueDate;
                return this;
            }

            public Builder setPeriod(int period) {
                this.period = period;
                return this;
            }

            public Builder setReturnDate(Date returnDate) {
                this.returnDate = returnDate;
                return this;
            }

            public Builder setFine(double fine) {
                this.fine = fine;
                return this;
            }

            public Issue build() {
                return new Issue(this);
            }
        }
}
