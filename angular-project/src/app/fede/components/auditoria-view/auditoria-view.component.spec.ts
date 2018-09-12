import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditoriaViewComponent } from './auditoria-view.component';

describe('AuditoriaViewComponent', () => {
  let component: AuditoriaViewComponent;
  let fixture: ComponentFixture<AuditoriaViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuditoriaViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuditoriaViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
