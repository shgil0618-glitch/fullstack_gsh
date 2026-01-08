// <rootDir>/setupTest.js
import '@testing-library/jest-dom';
import {cleanup} from '@testing-library/react';  //객체는 {}

afterEach(()=>{
    cleanup();
});



