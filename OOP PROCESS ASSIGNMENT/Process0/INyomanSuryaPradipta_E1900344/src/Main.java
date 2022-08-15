public class Main {
    public static void main(String[] args) {
        Administrator a1 = new Administrator("surya", "surya123","@", "asdf","ADM000");
        HealthcareCentre centreName1 = new HealthcareCentre("Balimed Hospital", "Jl. Mahendradatta No.57 X, Padangsambian, Kec. Denpasar Bar., Kota Denpasar, Bali 80119", a1);
        System.out.println(centreName1.getAdmin().getUsername());

        PCVS pcvs = new PCVS(20);


    }
}
