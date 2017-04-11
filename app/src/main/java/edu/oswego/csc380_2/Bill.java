package edu.oswego.csc380_2;

/**
 * Created by James on 2/23/2017.
 */
public class Bill {
    private double amount;

    //please let me commit

    public Bill(){
        amount = 0;
    }

    public void setAmount(double amount){
        if(amount > 0) {
            this.amount = amount;
        }
        else{
            throw new IllegalArgumentException("Amount cannot be less than 0.");
        }
    }

    public double getAmount(){
        return amount;
    }

    public double splitBillByNumber(int num){
        double cost = amount/num;
        return cost;
    }

    /*ALLOW FOR CUSTOMER TO SPLIT BILL BASED ON ORDERS
    public ArrayList<Double> splitBill(){
        ArrayList splitBill = new ArrayList<Double>();



        return splitBill;
    }
    */
}
