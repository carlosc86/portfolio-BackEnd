import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExperienciaDataService } from 'src/app/services/experiencia-data.service';
import { EditorData } from '../editorData';
import { ExperienciaData } from '../experienciaData';

@Component({
  selector: 'app-editor-experiencia',
  templateUrl: './editor-experiencia.component.html',
  styleUrls: ['./editor-experiencia.component.css']
})
export class EditorExperienciaComponent extends EditorData<ExperienciaData> implements OnInit {
  
  constructor(private fb:FormBuilder, private experienciaService:ExperienciaDataService) { 
    super(experienciaService);
    this.forms=fb.group({
      puesto:[''],
      tipoTrabajo:[''],
      descripcion:[''],
      nombreEmpresa:[''],
      urlLogoEmpresa:[''],
      fechaInicio:[''],
      fechaFin:['']
    });
  }

  protected borrarElemento(): ExperienciaData {
    return {
      id:NaN,
      puesto:"",
      tipoTrabajo:"",
      descripcion:"",
      nombreEmpresa:"",
      urlLogoEmpresa:"",
      fechaInicio:"",
      fechaFin:""
    };
  }

}
