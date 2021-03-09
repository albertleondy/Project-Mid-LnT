import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Vector<data> datas = new Vector<data>();
		int pilihan;
		int manager_count = 0;
		int supervisor_count = 0;
		int admin_count = 0;
		do {
			System.out.println("Selamat Datang!");
			System.out.println("1. Input Data");
			System.out.println("2. View Data");
			System.out.println("3. Update Data");
			System.out.println("4. Delete Data");
			System.out.println("5. Exit");
			System.out.println("Choose menu");
			pilihan=scan.nextInt();scan.nextLine();
			switch (pilihan) {
			case 1:
				String kode="", nama, jenis, kerja;
				int gaji = 0;
				boolean flag;
				do {
					System.out.print("Input nama karyawan [>=3]: ");
					nama = scan.nextLine();
				} while(nama.length() < 3);
				do {
					System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) : ");
					jenis = scan.nextLine();
					flag = true;
					if(jenis.equals("Laki-laki")||jenis.equals("Perempuan")) {
						flag = false;
					}
						
				} while(flag);
				do {
					System.out.print("Input jabatan (Manager | Supervisor | Admin) (Case Sensitive) : ");
					kerja = scan.nextLine();
					flag = true;
					if(kerja.equals("Manager")||kerja.equals("Supervisor")||kerja.equals("Admin")) {
						flag = false;
					}
				} while(flag);
				
				Random r = new Random();
				for (int i = 0; i < 2; i++) {				
					char c = (char)(r.nextInt(26) + 'A');
					kode += c;
				}
				kode += '-';
				for(int i = 0; i < 4; i++) {
					char num = (char)(r.nextInt(9) + '0');
					kode += num;
				}
				System.out.println("Berhasil menambahkan karyawan dengan id "+kode);
				if(kerja.equals("Manager")){
					gaji = 8000000;
					++manager_count;
					if((manager_count - 1) % 3 == 0 && manager_count != 1) {
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
						int comma = manager_count - 1;
						for(data data : datas) {
							if(data.getKerja().equals("Manager")) {
								int bonus = data.getGaji();
								bonus =  (int)(0.1 * bonus) + bonus;
								data.setGaji(bonus);
								System.out.print(data.getKode());
								if(comma != 1)
									System.out.print(", ");
									--comma;
							}
						}
					}
					System.out.println(manager_count);
				}
				else if(kerja.equals("Supervisor")) {
					gaji = 6000000;
					++supervisor_count;
					if((supervisor_count - 1) % 3 == 0 && supervisor_count != 1) {
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
						int comma = supervisor_count - 1;
						for(data data : datas) {
							if(data.getKerja().equals("Supervisor")) {
								int bonus = data.getGaji();
								bonus = (int) (0.075 * bonus) + bonus;
								data.setGaji(bonus);
								System.out.print(data.getKode());
								if(comma != 1)
									System.out.print(", ");
									--comma;
							}
						}
					}
					System.out.println(supervisor_count);
				}				
				else if(kerja.equals("Admin")) {
					gaji = 4000000;
					++admin_count;
					if((admin_count - 1) % 3 == 0 && admin_count != 1) {
						System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
						int comma = admin_count - 1;
						for(data data : datas) {
							if(data.getKerja().equals("Admin")) {
								int bonus = data.getGaji();
								bonus = (int) (0.05 * bonus) + bonus;
								data.setGaji(bonus);
								System.out.print(data.getKode());
								if(comma != 1)
									System.out.print(", ");
									--comma;
							}
						}
						System.out.print("\n");
					}
				}
				datas.add(new data(kode,nama,jenis,kerja,gaji));	
				System.out.println("Enter to return");
				scan.nextLine();
				break;
			case 2:
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|"); 
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				int i = 1;
				for(data data : datas) {
					System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13s|\n",i,data.getKode(),data.getNama(), data.getJenis(), data.getKerja(),data.getGaji());
					++i;
				}
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.println("Enter to return");
				scan.nextLine();
				break;
			case 3:
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|"); 
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				int j = 1;
				for(data data : datas) {
					System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13s|\n",j,data.getKode(),data.getNama(), data.getJenis(), data.getKerja(),data.getGaji());
					++j;
				}
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.println("Input angka yang ingin diupdate");
				int temp = scan.nextInt();
				scan.nextLine();
				String kode3="", nama3, jenis3, kerja3;
				int gaji3 = 0;
				boolean flag3;
				String pattern = "^[A-Z]{2}-\\d{4}$";
				Pattern regex = Pattern.compile(pattern);
				do {
					flag3 = true;
					System.out.print("Input kode karyawan : ");
					kode3 = scan.nextLine();
					Matcher match = regex.matcher(kode3);
					if(match.find()) {
						flag3 = false;
					}
				} while(flag3);
				
				do {
					System.out.print("Input nama karyawan [>=3]: ");
					nama3 = scan.nextLine();
				} while(nama3.length()<3);
				do {
					System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
					jenis3 = scan.nextLine();
					flag3 = true;
					if(jenis3.equals("Laki-laki")||jenis3.equals("Perempuan")) {
						flag3 = false;
					}
						
				} while(flag3);
				do {
					System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					kerja3 = scan.nextLine();
					flag3 = true;
					if(kerja3.equals("Manager")||kerja3.equals("Supervisor")||kerja3.equals("Admin")) {
						flag3 = false;
					}
				} while(flag3);
				
				do {
					System.out.print("Input gaji karyawan (Angka): ");
					gaji3 = scan.nextInt();
					scan.nextLine();						

				} while (gaji3 < 1||gaji3 > 100000000);		
				--temp;
				datas.get(temp).setNama(nama3);
				datas.get(temp).setJenis(jenis3);
				datas.get(temp).setKerja(kerja3);
				datas.get(temp).setGaji(gaji3);
				System.out.println("Enter to return");
				scan.nextLine();
				break;
			case 4:
				System.out.println("Input angka yang ingin di delete");
				int temp4 = scan.nextInt();
				scan.nextLine();
				datas.remove(--temp4);
				System.out.println("Delete berhasil");
				System.out.println("Enter to return");
				scan.nextLine();
				break;
			case 5:
				break;
			}
		} while (pilihan!=5);
	}
	
}
