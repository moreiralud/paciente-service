# 🧍 GeoSUS - Paciente Service

Este microsserviço faz parte do sistema **GeoSUS - Fila Única com Geolocalização para o SUS**. Ele é responsável pelo gerenciamento de pacientes, permitindo o cadastro, a listagem e a consulta por CPF.

## 📌 Funcionalidades

- Cadastro de pacientes com nome, CPF e localização.
- Garantia de CPF único no sistema.
- Consulta de pacientes por CPF.
- Listagem de todos os pacientes cadastrados.
- Integração com o `fila-service` para direcionamento com base na localização.

## 🧱 Arquitetura

[controller] → [application] → [domain] ←→ [infrastructure]


O projeto segue a divisão:
- `domain`: entidades e regras de negócio.
- `application`: casos de uso.
- `adapter`: interfaces REST e persistência.
- `infrastructure`: configurações, banco e persistência JPA.

## 🌐 Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/pacientes` | Cadastra novo paciente |
| `GET`  | `/pacientes/por-cpf?cpf={cpf}` | Consulta paciente por CPF |
| `GET`  | `/pacientes` | Lista todos os pacientes |

## 💡 Exemplo de payload

```json
{
  "nome": "Maria da Silva",
  "cpf": "12345678900",
  "latitude": -10.9472,
  "longitude": -37.0731
}


🧪 Testes
Framework: JUnit 5 + Mockito.

Cobertura mínima de 80% validada com JaCoCo.

Relatórios gerados na pasta /target/site/jacoco.

🐘 Banco de Dados
PostgreSQL com versionamento via Flyway.

Scripts localizados em resources/db/migration.
