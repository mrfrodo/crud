package no.frode.div;

public class FibGame {

    public String fib(int count) {

        int n1=0,n2=1,n3,i;
        StringBuilder sb = new StringBuilder();

        sb.append(n1 + " " + n2+ " ");

        System.out.print(n1+" "+n2);

        for(i=2;i<count;++i) {
            n3=n1+n2;
            sb.append(n3+ " ");
            n1=n2;
            n2=n3;
        }

        return sb.toString();
    }
}
