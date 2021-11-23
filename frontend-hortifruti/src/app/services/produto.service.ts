import { Produto } from '../model/Produto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http:HttpClient) {}
  
  private readonly urlBase='http://localhost:8080/api/produto';

  getProdutos() {
    return this.http.get<Produto[]>(this.urlBase);
  }

  getProdutosAtivos() {
    return this.http.get<Produto[]>(this.urlBase+'/ativos');
  }

  getProdutoCodigo(codigo: string){
    return this.http.get<Produto>(this.urlBase + '/codigo/' + codigo);
  }

  getProduto(id: any){
    return this.http.get<Produto>(this.urlBase + '/' + id);
  }

  postProduto(produto: Produto){
    return this.http.post<string>(this.urlBase, produto);
  }

  editProduto(id: any, produto: Produto){
    return this.http.put(this.urlBase + '/' + id, produto);
  }

  editStatusProduto(id: String, status: String){
    return this.http.put(this.urlBase + '/' + id + '/status', status);
  }

  deleteProduto(id: any){
    return this.http.delete(this.urlBase + '/' + id);
  }

}
