public class Employee {
    String name, surname, role, salary, phone, email;
    String address, district, amphur, province, postcode;
    String housing;

    public Employee(String name, String surname, String role, String salary, String phone, String email,
                    String address, String district, String amphur, String province, String postcode, String housing) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.district = district;
        this.amphur = amphur;
        this.province = province;
        this.postcode = postcode;
        this.housing = housing;
    }
}