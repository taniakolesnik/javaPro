package uk.co.taniakolesnik;

public class ClassOne {

    @Test(a=2, b=1)
    public void test(int a, int b) {
        System.out.println(a + b);
    }

    @Test(a=3, b=6)
    public void test2(int a, int b) {
        System.out.println(a + b);
    }

}
