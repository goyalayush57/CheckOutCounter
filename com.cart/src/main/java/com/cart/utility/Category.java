package com.cart.utility;

public enum Category {
A(10),
B(20),
C(0);


private final int salesTax;
	
Category(int salesTax) {
    this.salesTax = salesTax;
}

public int getSalesTax() {
    return this.salesTax;
}
}
