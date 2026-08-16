package org.example.examination;

public class GCD {

    public int gcd(int n1,int n2){
        if(n1<n2){
            return gcd(n2,n1);
        }

        while(n2!=0){
            int temp = n1%n2;
            n1 = n2;
            n2 = temp;
        }

        return n1;
    }
}
