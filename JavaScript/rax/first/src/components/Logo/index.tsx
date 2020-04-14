import { createElement } from 'rax';
import Image from 'rax-image';

import './index.css';

interface LogoProps {
  uri: string;
}

export default (props: LogoProps) => {
  const { uri } = props;
  return (
    <Image
      className="logo"
      source={{ uri }}
    />
  );
};
