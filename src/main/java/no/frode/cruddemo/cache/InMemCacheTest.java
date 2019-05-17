package no.frode.cruddemo.cache;

public class InMemCacheTest {

    public static void main (String... args) {

        InMemCache cache = new InMemCache();

        cache.add("key", "eplekake", 1000);

        for (int i=0;i<50;i++) {
            System.out.print("printing out value of cache: ");
            System.out.println(cache.get("key"));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
