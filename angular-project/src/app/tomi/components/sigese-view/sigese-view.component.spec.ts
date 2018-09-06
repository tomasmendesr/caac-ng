import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SigeseViewComponent } from './sigese-view.component';

describe('SigeseViewComponent', () => {
  let component: SigeseViewComponent;
  let fixture: ComponentFixture<SigeseViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SigeseViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SigeseViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
