import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MensualSeccionDComponent } from './mensual-seccion-d.component';

describe('MensualSeccionDComponent', () => {
  let component: MensualSeccionDComponent;
  let fixture: ComponentFixture<MensualSeccionDComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MensualSeccionDComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MensualSeccionDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
