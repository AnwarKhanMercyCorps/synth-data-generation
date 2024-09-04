import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
// @ts-ignore
import includeHtml from "vite-include-html-plugin";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react(),includeHtml()],
  base: '/r/',
  build: {
    outDir: '../resources/static/r',
    emptyOutDir: true, // also necessary
  }
})

