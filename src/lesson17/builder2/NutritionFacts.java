package lesson17.builder2;

public class NutritionFacts {
    private final int servings;
    private final int fat;
    private final int calories;

    public static class Builder{
        private final int servings;
        private int fat = 0;
        private int calories = 0;

        public Builder(int servings){
            this.servings = servings;
        }

        public Builder setFat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder){
        servings = builder.servings;
        fat = builder.fat;
        calories = builder.calories;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new Builder(10).setCalories(456).setFat(4).build();

    }
}
