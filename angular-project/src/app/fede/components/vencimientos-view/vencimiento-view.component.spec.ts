import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VencimientoViewComponent } from './vencimiento-view.component';

describe('VencimientoViewComponent', () => {
  let component: VencimientoViewComponent;
  let fixture: ComponentFixture<VencimientoViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VencimientoViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VencimientoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
