package ge.davab.leetcode.design_a_food_rating_system_2353;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class FoodRatings {

    public static class Food {
        private final String name;

        private final String cuisine;

        private int rating;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public String getCuisine() {
            return cuisine;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return getName() + " " + getCuisine() + " " + getRating();
        }
    }

    private final Map<String, Food> foodByName = new HashMap<>();

    private final Map<String, Set<Food>> foodByCuisine = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int index = 0; index < foods.length; ++index) {
            Food food = new Food(foods[index], cuisines[index], ratings[index]);
            foodByName.put(foods[index], food);
            foodByCuisine
                    .computeIfAbsent(
                            cuisines[index],
                            k -> new TreeSet<>((f1, f2) -> {
                                int rateDiff = -Integer.compare(f1.getRating(), f2.getRating());
                                if (rateDiff != 0) return rateDiff;
                                return f1.getName().compareTo(f2.getName());
                            }
                            ))
                    .add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food _food = foodByName.get(food);
        foodByCuisine.get(_food.getCuisine()).remove(_food);
        _food.setRating(newRating);
        foodByCuisine.get(_food.getCuisine()).add(_food);
    }

    public String highestRated(String cuisine) {
        return foodByCuisine.get(cuisine).stream()
                .findFirst()
                .orElseThrow()
                .getName();
    }
}


