import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstructuralSeccionFComponent } from './estructural-seccion-f.component';

describe('EstructuralSeccionFComponent', () => {
  let component: EstructuralSeccionFComponent;
  let fixture: ComponentFixture<EstructuralSeccionFComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstructuralSeccionFComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstructuralSeccionFComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
