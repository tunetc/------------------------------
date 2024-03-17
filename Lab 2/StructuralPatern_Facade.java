public class StructuralPatern_Facade {
    public static class Geology {
        public void procceseGeology() {
            System.out.println("Я вивчив структуру дна моря");
        }
    }

    public static class Accountant {
        public void procceseAccountant() {
            System.out.println("Я розробив кошторисний план");
        }
    }

    public  static class Contractor {
        public void procceseContractor() {
            System.out.println("Я найняв підрядника");
        }
    }

    public  static class Construction {
        public void procceseConstruction() {
            System.out.println("Підрядник збудував проміжні опори");
        }
    }

    public  static class ConstructionUp {
        public void procceseConstructionUp() {
            System.out.println("Підрядник збудував усі прольоти");
        }
    }

    public  static class FinishConstruction {
        public void procceseFinishConstruction() {
            System.out.println("Підрядник завершив виконання поставленої задачі");
        }
    }

    public  static class Discovery {
        public void procceseDiscovery() {
            System.out.println("Міст здано у екслуатацію");
        }
    }

    public static class Facade {
        private Geology geology;
        private Accountant accountant;
        private Contractor contractor;
        private Construction construction;
        private ConstructionUp constructionUp;
        private FinishConstruction finishConstruction;
        private Discovery discovery;


        public Facade() {
            this.geology = new Geology();
            this.accountant = new Accountant();
            this.contractor = new Contractor();
            this.construction = new Construction();
            this.constructionUp = new ConstructionUp();
            this.finishConstruction = new FinishConstruction();
            this.discovery = new Discovery();

        }

        public void startComputer() {
            geology.procceseGeology();
            accountant.procceseAccountant();
            contractor.procceseContractor();
            construction.procceseConstruction();
            constructionUp.procceseConstructionUp();
            finishConstruction.procceseFinishConstruction();
            discovery.procceseDiscovery();
        }
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.startComputer();
    }
}