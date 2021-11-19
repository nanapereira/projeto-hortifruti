import { Produto } from '../model/Produto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http:HttpClient) {}
  
  private readonly Url='http://localhost:8080/api/produto';

  getProdutos() {
    return this.http.get<Produto[]>(this.Url);
  }

  getProdutosAtivos() {
    return this.http.get<Produto[]>(this.Url+'/ativos');
  }

  getProdutoCodigo(codigo: string){
    return this.http.get<Produto>(this.Url + '/codigo/' + codigo);
  }

  postProduto(produto: Produto){
    return this.http.post<Produto>(this.Url, produto);
  }

  editProduto(id: String, produto: Produto){
    return this.http.put(this.Url + '/' + id, produto);
  }

  deleteProduto(id: String){
    return this.http.delete(this.Url + '/' + id);
  }

}