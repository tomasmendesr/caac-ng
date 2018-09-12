import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PagosViewComponent } from './pagos-view.component';

describe('PagosViewComponent', () => {
  let component: PagosViewComponent;
  let fixture: ComponentFixture<PagosViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagosViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PagosViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
