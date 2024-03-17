public class ReproductivePatern_Builder {
    public static class Animal {
        private String name;
        private Integer age;
        private String animal_name;
        private String color;
        private Boolean sex;

        private Animal(AnimalBuilder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.animal_name = builder.animal_name;
            this.color = builder.color;
            this.sex = builder.sex;
        }

        public static class AnimalBuilder {
            private String name;
            private Integer age;
            private String animal_name;
            private String color;
            private Boolean sex;;

            public AnimalBuilder(String name) {
                this.name = name;
            }

            public AnimalBuilder setAge(Integer age) {
                this.age = age;
                return this;
            }

            public AnimalBuilder setAnimal_name(String animal_name) {
                this.animal_name = animal_name;
                return this;
            }

            public AnimalBuilder setColor(String color) {
                this.color = color;
                return this;
            }

            public AnimalBuilder setSex(Boolean sex) {
                this.sex = sex;
                return this;
            }

            public Animal build() {
                return new Animal(this);
            }
        }
    }
    public static void main(String[] args) {
        Animal animal1 = new Animal.AnimalBuilder("Себек").setAnimal_name("Лев").setAge(15).setColor("Жовтий").setSex(true).build();

        Animal animal2 = new Animal.AnimalBuilder("Патіфон").setSex(false).build();

        Animal animal3 = new Animal.AnimalBuilder("Макрамешка").build();

        System.out.println("Кличка: " + animal1.name);
        System.out.println("Вік: " + animal1.age);
        System.out.println("Забарвлення: " + animal1.color);
        System.out.println("Назва тварини: " + animal1.animal_name);
        System.out.println("Стать: " + (animal1.sex != null ? (animal2.sex ? "Самець\n" : "Самка\n") : null));

        System.out.println("Кличка: " + animal2.name);
        System.out.println("Вік: " + animal2.age);
        System.out.println("Забарвлення: " + animal2.color);
        System.out.println("Назва тварини: " + animal2.animal_name);
        System.out.println("Стать: " + (animal2.sex != null ? (animal2.sex ? "Самець\n" : "Самка\n") : null));

        System.out.println("Кличка: " + animal3.name);
        System.out.println("Вік: " + animal3.age);
        System.out.println("Забарвлення: " + animal3.color);
        System.out.println("Назва тварини: " + animal3.animal_name);
        System.out.println("Стать: " + (animal3.sex != null ? (animal2.sex ? "Самець\n" : "Самка\n") : null));
    }
}
