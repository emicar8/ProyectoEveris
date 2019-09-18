import { Base } from './base';
import { Star } from './star';

export class Planet extends Base{

    name : string;
    size : number;
    star : Star;

    constructor(){
        super();
    }
}