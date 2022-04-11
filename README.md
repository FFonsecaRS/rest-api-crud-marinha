# rest-api-crud-marinha
Api solicitada para processo seletivo

As rotas para o CRUD de categoria e produto estão no formato padrão variando a passagem de parametro ou não e os metodos HTTP.
Categoria: http://localhost:8080/categoria
Produto: http://localhost:8080/produto

Exemplos do JSON para utilizar o CRUD da API REST:

1 - Criar uma categoria:  POST na rota http://localhost:8080/categoria
{
	"nome":"Bazar",
	"descricao":"Produtos de utilidade geral"
}

2 - Atualizar uma categoria: PUT passando ID na rota http://localhost:8080/categoria/1
{
	"nome":"Bazar",
	"descricao":"Produtos de utilidade geral para o lar"
}

3 - Criar um produto: POST na rota http://localhost:8080/produto
{
	"codigo":"AB788",
	"nome":"Nafitalina pacate com 10",
	"valor":15.50,
	"categoria":{"id": 1}
}
