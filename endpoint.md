## Animal

| Endpoint                        | Method | Description                   |
|---------------------------------|--------|-------------------------------|
| `/animals/getAll`               | GET    | List all animals              |
| `/animals/getByAnimalId/{id}`   | GET    | Get animal by Id              |
| `/animals/save`                 | POST   | Add new animal                |
| `/animals/update`               | PUT    | Update animal record          |
| `/animals/delete/{id}`          | DELETE | Delete animal record          |
| `/animals/getByCustomerId/{id}` | GET    | Animal listing by customer id |

## Customer

| Endpoint                      | Method | Description            |
|-------------------------------|--------|------------------------|
| `/customers/get`              | GET    | List all customers     |
| `/customers/getById/{id}`     | GET    | Get customer by Id     |
| `/customers/getByName/{name}` | GET    | Get customer by name   |
| `/customers/getPets/{id}`     | GET    | Get pets of customer   |
| `/customers/add`              | POST   | Add new customer       |
| `/customers/update`           | PUT    | Update customer record |
| `/customers/delete/{id}`      | DELETE | Delete customer record |

## Doctor

| Endpoint                    | Method | Description          |
|-----------------------------|--------|----------------------|
| `/doctors/getAll`           | GET    | List all doctor      |
| `/doctors/getByName/{name}` | GET    | Get doctor by name   |
| `/doctors/save`             | POST   | Add new doctor       |
| `/doctors/update`           | PUT    | Update doctor record |
| `/doctors/delete/{id}`      | DELETE | Delete doctor record |

## Available Day

| Endpoint              | Method | Description                        |
|-----------------------|--------|------------------------------------|
| `/availableDate/getAll`       | GET    | List all doctor available days     |
| `/availableDate/getByID/{id}` | GET    | Get doctor available day by Id     |
| `/availableDate/save`         | POST   | Add new doctor available day       |
| `/availableDate/update`       | PUT    | Update doctor available day record |
| `/availableDate/delete/{id}`  | DELETE | Delete doctor available day record |

## Vaccine

| Endpoint                                 | Method | Description                   |
|------------------------------------------|--------|-------------------------------|
| `/vaccines/get`                          | GET    | List all vaccines             |
| `/vaccines/getById/{id}`                 | GET    | Get vaccine by Id             |
| `/vaccines/add`                          | POST   | Add new vaccine               |
| `/vaccines/update`                       | PUT    | Update vaccine record         |
| `/vaccines/delete/{id}`                  | DELETE | Delete vaccine record         |
| `/vaccines/getBetween?startDate?endDate` | GET    | Vaccine listing by date range |
| `/vaccines/getAnimalVaccine/{id}`        | GET    | Listing vaccines by animal id |

## Appointment

| Endpoint                             | Method | Description                                           |
|--------------------------------------|--------|-------------------------------------------------------|
| `/appointments/getAll`               | GET    | List all appointments                                 |
| `/appointments/getById/{id}`         | GET    | Get appointment by Id                                 |
| `/appointments/getByAnimalIdBetween` | GET    | Get all appointments by animal between dates enquired |
| `/appointments/getByDoctorIdBetween` | GET    | Get all appointments by doctor between dates enquired |
| `/appointments/save"`                | POST   | Add new appointment                                   |
| `/appointments/update"`              | PUT    | Update appointment record                             |
| `/appointments/delete/{id}"`         | DELETE | Delete appointment record                             |









