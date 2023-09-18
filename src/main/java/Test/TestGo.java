package Test;

public class TestGo {
    public static void main(String[] args) {

    }
}



/*

Exceptions
OOPS
SOLID
Principle
Design Pattern

Expense Sharing Application
---------------------------

Users: U1 (YOU), U2, U3, U4
Transaction T1: 1000
CASE: SPLIT EQUAL

U2 -> U1 : 250
U3 -> U1 : 250
U4 -> U1 : 250

Case: EXACT

Transaction T2: 1100
(U1, U3, U4) -->

U3 -> U1: 500
U4 -> U1: 600

U3 Balance: 250 + 500 = 750
U4 Balance: 250 + 600 = 850
U2 Balance: 250 + 0 = 250

Case: SHARE

Transaction T3: 2000

U1 Share: 1
U2 Share: 2
U3 Share: 1
U4 Share: 1

U2 -> 800
U1 -> 400
U3 -> 400
U4 -> 400

U2 -> 800 + 250 = 1050
U3 -> 400 + 750 = 1150
U4 -> 400 + 850 = 1250


Before T3, U3 -> U1 = 750
Currently U1 -> U3 = 400
U3 -> U1 = 750 - 400 = 350


U1 Balance: 0
U3 Balance: 350
U2 Balance: 250			U2->U3 Balance: 800
U4 Balance: 850			U4->U3 Balance: 400


Users: Id, name, email, mobile
Amount should be handled till 2 decimal places.
SHARE will always be an integer
In case of EXACT, you need to verify if the total sum of shares is equal to the total amount or not.

Implementation:

addUser(<U>, Details)
recordExpense(amount, description, involvedUsers, paid, splitType)
recordExpense(amount, description, involvedUsers, paid, splitType, shareDetails)
getBalance(User <U>)
getBalanceSheet()

You can store all data in memory.
You can print outputs






*/
