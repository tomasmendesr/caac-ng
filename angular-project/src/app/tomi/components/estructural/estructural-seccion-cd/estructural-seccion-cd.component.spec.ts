import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstructuralSeccionCdComponent } from './estructural-seccion-cd.component';

describe('EstructuralSeccionCdComponent', () => {
  let component: EstructuralSeccionCdComponent;
  let fixture: ComponentFixture<EstructuralSeccionCdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstructuralSeccionCdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstructuralSeccionCdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
