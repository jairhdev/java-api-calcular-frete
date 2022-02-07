# java-api-calcular-frete
Calcula o valor total do frete e a data prevista da entrega.

- Java 17, Spring Boot 2.6.3

# Regras cálculo do frete e prazo de entrega
- O valor do frete é cobrado pelo peso da encomenda. O valor para cada KG é R$1,00.
- CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia.
- CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias.
- CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias.

# v1.0
- Banco de dados H2.
- Documentação Swagger:
http://localhost:8080/swagger-ui/index.html
