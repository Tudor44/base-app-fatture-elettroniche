import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FattureListaComponent } from './fatture-lista.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('FattureListaComponent', () => {
  let component: FattureListaComponent;
  let fixture: ComponentFixture<FattureListaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [FattureListaComponent, HttpClientTestingModule, RouterTestingModule]
    });
    fixture = TestBed.createComponent(FattureListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
