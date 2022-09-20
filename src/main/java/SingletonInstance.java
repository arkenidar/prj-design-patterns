public class SingletonInstance {
    private static SingletonInstance singletonInstance;

    private SingletonInstance() {
    }

    public static SingletonInstance newInstance() {
        if (singletonInstance == null) {
            System.out.println("instancing...");
            singletonInstance = new SingletonInstance();
        }
        return singletonInstance;
    }

    public static void main(String[] args) {
        SingletonInstance.newInstance();
        SingletonInstance.newInstance();
        SingletonInstance.newInstance();
    }
}
