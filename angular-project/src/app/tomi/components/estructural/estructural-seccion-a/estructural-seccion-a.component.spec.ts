import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstructuralSeccionAComponent } from './estructural-seccion-a.component';

describe('EstructuralSeccionAComponent', () => {
  let component: EstructuralSeccionAComponent;
  let fixture: ComponentFixture<EstructuralSeccionAComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstructuralSeccionAComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstructuralSeccionAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
