package org.jay010.entity;

import java.util.Date;

public class Issue {

    private int issueID;
    private int userID;
    private int bookID;
    private Date issueDate;
    private int period;
    private Date returnDate;
    private double fine;

    private static final double PENALTY_COST_PER_DAY = 5.00;

    public Issue () {}
    public Issue(Builder builder) {
        this.issueID = builder.issueID;
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

    public void calculateFine(){
        this.fine = numberOfDaysOverdue() * PENALTY_COST_PER_DAY;
    }

    // Get the number of days overdue by subtracting the period from the number of days between the issue date
    // and the return date
        protected int numberOfDaysOverdue() {
            int days = daysBetween(this.issueDate, this.returnDate) - this.period;

            if (days < 0)
                return 0;
            else
                return days;
        }

        public static class Builder {

            private int issueID;
            private int userID;
            private int bookID;
            private Date issueDate;
            private int period;
            private Date returnDate;
            private double fine;

            public Builder setIssueID(int issueID) {
                this.issueID = issueID;
                return this;
            }

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

    // Get the number of days between the issue date and the return date
        private int daysBetween(Date d1, Date d2){
            return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)+1);
        }
}
