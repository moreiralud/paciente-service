
O projeto segue os princípios da **Arquitetura Limpa** com as seguintes camadas:

- `domain`: entidade `Paciente` e contrato `PacienteRepository`.
- `application`: casos de uso (ex: `CadastrarPacienteUseCase`, `ListarTodosPacientesUseCase`).
- `adapter`: controller REST e adaptadores de entrada/saída.
- `infrastructure`: JPA, Flyway, banco de dados e configurações.

---

## 🌐 Endpoints REST

| Método | Endpoint                         | Descrição                     |
|--------|----------------------------------|-------------------------------|
| `POST` | `/pacientes`                     | Cadastra um novo paciente     |
| `GET`  | `/pacientes/por-cpf?cpf={cpf}`   | Consulta paciente por CPF     |
| `GET`  | `/pacientes`                     | Lista todos os pacientes      |

---

## 🧪 Testes

- Frameworks: **JUnit 5** + **Mockito**
- Estratégia: foco em testar **casos de uso**, **controller** e **repositórios**
- Relatórios: gerados automaticamente em  
  `target/site/jacoco/index.html`

---

## 📈 Cobertura de Testes

- ✅ **Cobertura efetiva: 82%**
- 🎯 A cobertura é focada nas **camadas com lógica de negócio**:
    - `domain`
    - `application`
    - `adapter.controller`
    - `infrastructure.repository` e `gateway`
- 🛑 **Classes excluídas deliberadamente do escopo de teste**:
    - `PacienteServiceApplication.java`
    - `SwaggerConfig.java`
    - `PacienteUseCaseConfig.java`
    - Pacotes `entity` e `mapper`

---

## 💾 Banco de Dados

- Banco: **PostgreSQL**
- Versionamento com **Flyway**
- Scripts localizados em:  
  `src/main/resources/db/migration`

---

## 💡 Exemplo de Payload

```json
{
  "nome": "Maria da Silva",
  "cpf": "12345678900",
  "dataNascimento": "1990-01-01",
  "endereco": "Rua Exemplo, 123",
  "latitude": -10.9472,
  "longitude": -37.0731
}
