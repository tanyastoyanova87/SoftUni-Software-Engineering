package Programming_Fundamentals_With_Java.L06ObjectsAndClassesExercise.P01AdvertisementMessage;

import java.util.Random;

public class Message {

    Random random = new Random();

    private String[] phrase = {"Excellent product.",
            "Such a great product.",
            "I always use that product.",
            "Best product of its category.",
            "Exceptional product.",
            "I can’t live without this product."};
    private String[] events = {"Now I feel good.",
            "I have succeeded with this product.",
            "Makes miracles. I am happy of the results!",
            "I cannot believe but now I feel awesome.",
            "Try it yourself, I am very satisfied.",
            "I feel great!"};
    private String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
    private String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

    public String randomMessage () {
        return String.format("%s %s %s - %s",
                phrase[random.nextInt(phrase.length)],
                events[random.nextInt(events.length)],
                authors[random.nextInt(authors.length)],
                cities[random.nextInt(cities.length)]);
    }
}
