import { Base } from './base';
import { Planet } from './planet';

export class Star extends Base{
    
    name : string;
    density : number;
    planets : Planet[] = [];
}