# Frivillig prosjekt 2022

## Introduksjon
Frivillig prosjekt i Fullstack Applikasjonsutvikling (IDATT2105) ved NTNU <br> <br>
Gruppe: 
- Olav Dagestad Eikrem
- Sindre Glomnes
- Øyvind Bjøntegaard

<br>Årets prosjektoppgave er å lage et alternativ til Qs. 


## Installasjon

### Backend

```bash
cd Full-stack-prosjekt\backend
# With Maven  

# With Docker-compose (?)
docker-compose -f docker-compose build
docker-compose -f docker-compose up
```

### Frontend

```bash
cd Full-stack-prosjekt\frontend
# Run the app
npm run serve
```



## Funskjonalitet
- Logge inn. enten som student, studass eller admin
- Student: Liste fag
- Student: liste øvinger (godkjent, ikke godkjent, ikke vurdert)
- Student: Still i kø for godkjenning/hjelp
- Studass: Godkjenne øvinger
- Admin: Liste alle fag og alle øvinger
- Admin: Legge til brukere
- Admin: Legge til fag
- Alle: Endre passord.


## Nåværende mangler
De fleste manglene kommer av at koblingen mellom front- og backend ikke er
ferdig utviklet.
- Legge til brukere
- Legge til fag
- Forbedret på/avloggings metode
- Detaljer om fag (øvinger)
- Kø system
- Godkjenning av øvinger
- Testing
- CI
