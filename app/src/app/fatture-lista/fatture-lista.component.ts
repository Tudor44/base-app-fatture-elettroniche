import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Fattura } from '../model/fattura';
import { HttpClient, HttpParams } from '@angular/common/http';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-fatture-lista',
  standalone: true,
  imports: [CommonModule, RouterLink, MatButtonModule, MatTableModule, MatIconModule],
  templateUrl: './fatture-lista.component.html',
  styleUrls: ['./fatture-lista.component.css']
})
export class FattureListaComponent {
  title = 'Fatture in rilevate in attesa di invio';
  loading = true;
  params = new HttpParams()
    .set('dataInizio', '2023-07-01')
    .set('dataFine', '2023-07-30')
    .set('tipo', 'ATTIVA');

  fatture: Fattura[] = [];
  displayedColumns = ['data', 'numero', 'nome', 'tipo', 'stato'];

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.caricaFatture();
  }

  caricaFatture(): void {
    this.loading = true;
    this.http.get<Fattura[]>('http://localhost:8080/api/fatture', { params: this.params }).subscribe((data: Fattura[]) => {
      this.fatture = data;
      this.loading = false;
    });
  }


}
