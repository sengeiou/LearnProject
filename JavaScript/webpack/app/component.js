export default (text='cocoa1231') => {
  const element = document.createElement('h1');
  element.innerHTML = text; 
  
  return element;
};