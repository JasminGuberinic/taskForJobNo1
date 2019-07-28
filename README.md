# taskForJobNo1
Tip zadatka sa razgovora za posao.


Za naseg klijenta koji se bavi telekomunikacionim uslugama, potrebno je obezbijediti servis koji ce omoguciti cuvanje informacija o svim internet baziranim proizvodima na koje su pretplaceni njihovi korisnici. 
Raspolazemo sa sljedecim korisnickim zahtjevima:
Proizvodi su definisani sa odredjenim brojem tehnickih karakteristika, kao sto su: Upstream, Downstream, Tip tehnologije: VDSL, ISDN, xDSL…, vrsta uredaja: DSLAM, MDU, DPU, DPO, ONT…   koji se koriste za modeliranje proizvoda.
Korisnik u svakom momentu sadasnosti moze imati samo jedan proizvod.
Zahtjev za dodjelu pretplate na odredjeni proizvod korisniku, izmjenu pretplate ili njeno uklanjanje, dolazi od strane drugog sistema preko http rest servisa u vidu json poruke 
Licni podaci korisnika se cuvaju u odvojenom sistemu i njih nije potrebno perzistirati u ovom. Razmjenjuje se samo identifikator korisnika (user_id)
Servis treba biti u mogucnosti vratiti sve aktuelne proizvode za sve korisnike, zajedno sa tehnickim detaljima proizvoda. Format ove poruke je slobodan.
Servis takodjer treba biti u mogucnosti vratiti aktuelan proizvod za trazenog korisnika (za jednog korisnika)
Servis ne treba graficki korisnicki interfejs. On treba biti u mogucnosti komunicirati sa drugim sistemima preko unaprijed definisanih json poruka

U daljoj analizi je zakljuceno da bi bilo potrebno voditi racuna o cinjenici da se u praksi odredjeni proizvodi narucuju unaprijed, te da bi trebalo obezbijediti mogucnost historizacije i pojam trenutno aktivnog proizvoda. Ovo nije bio korisnicki zahtjev, ali bi njegov razvoj u ranoj fazi znatno olaksao kasniju nadogradnju servisa, te je sa nase strane zakljuceno da bi bilo korisno imati vec ranije razvijenu i ovu funkcionalnost ukoliko se ista moze razviti u unaprijed definisanom vremenskom okviru.

Primjer json poruke za unos/izmjenu proizvoda:
{
  "user_id": 123,
  "product_id": 12
}


Tehnicki zahtjevi:
Zadatak je realizovati koristeci java programski jezik. Source kod treba biti dobro dokumentovan I pokriven unit testovima. Uz source kod priloziti I uputstvo za instalaciju.
