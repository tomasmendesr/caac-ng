import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstructuralSeccionGComponent } from './estructural-seccion-g.component';

describe('EstructuralSeccionGComponent', () => {
  let component: EstructuralSeccionGComponent;
  let fixture: ComponentFixture<EstructuralSeccionGComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstructuralSeccionGComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstructuralSeccionGComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
